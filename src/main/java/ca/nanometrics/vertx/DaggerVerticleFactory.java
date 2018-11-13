package ca.nanometrics.vertx;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import io.vertx.core.Verticle;
import io.vertx.core.spi.VerticleFactory;

@Singleton
public class DaggerVerticleFactory implements VerticleFactory
{
  private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(DaggerVerticleFactory.class);

  public static final String PREFIX = "dagger";

  private final Map<Class< ? >, Provider<Verticle>> m_verticleMap;

  @Inject
  public DaggerVerticleFactory(Map<Class< ? >, Provider<Verticle>> verticleMap)
  {
    m_verticleMap = verticleMap;
  }

  @Override
  public Verticle createVerticle(String verticleName, ClassLoader classLoader) throws Exception
  {
    Provider<Verticle> verticle = m_verticleMap.get(sanitizeVerticleClassName(verticleName));
    if (verticle == null)
    {
      throw new IllegalStateException("No provider for verticle type " + verticleName + " found");
    }

    LOG.trace("Verticle for type: {} created", verticleName);
    return verticle.get();
  }

  @Override
  public String prefix()
  {
    return PREFIX;
  }

  /**
   * Sanitize the verticle name by removing the prefix for map lookup in m_verticleMap.
   * <p>
   * Notice, When deploying a verticle using the VerticleFactory, the verticle name template is: <BR>
   * "dagger:<verticle name>" in order to distinguish between a case where it can deploy verticle not through the
   * factory.
   *
   * @param verticleName
   * @return
   * @throws ClassNotFoundException
   */
  private Class< ? > sanitizeVerticleClassName(String verticleName) throws ClassNotFoundException
  {
    String name = verticleName.substring(verticleName.lastIndexOf(":") + 1);
    try
    {
      return Class.forName(name);
    }
    catch (ClassNotFoundException e)
    {
      LOG.error("Could not find class for {} in classloader {}", verticleName, getClass().getClassLoader());
      throw e;
    }
  }
}
