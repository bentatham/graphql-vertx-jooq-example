package ca.nanometrics.vertx;

import dagger.Binds;
import dagger.Module;
import io.vertx.core.spi.VerticleFactory;

@Module
public abstract class DaggerVerticleFactoryModule
{
  @Binds
  public abstract VerticleFactory provideVerticleFactory(DaggerVerticleFactory factory);
}
