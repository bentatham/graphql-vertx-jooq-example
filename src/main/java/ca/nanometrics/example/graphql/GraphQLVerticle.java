package ca.nanometrics.example.graphql;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.reactivex.ext.web.Router;
import io.vertx.reactivex.ext.web.handler.BodyHandler;

@Singleton
public class GraphQLVerticle extends AbstractVerticle
{
  static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(GraphQLVerticle.class);

  private static final String PATH_GRAPHQL = "/graphql";
  private static final String PATH_ALL = "/*";

  private final Provider<GraphQLHandler> m_handler;

  @Inject
  public GraphQLVerticle(Provider<GraphQLHandler> handler)
  {
    m_handler = handler;
  }

  public void registerServerRouter(Router serverRouter)
  {
    final Router router = Router.router(vertx);

    // Handle graphql queries
    router.post(PATH_ALL).handler(BodyHandler.create()); // must get body first
    router.getDelegate().post(PATH_ALL).handler(m_handler.get());
    serverRouter.mountSubRouter(PATH_GRAPHQL, router);
  }
}
