package ca.nanometrics.example.graphql;

import javax.inject.Inject;
import javax.inject.Provider;

import graphql.schema.GraphQLSchema;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

public final class GraphQLHandler implements Handler<RoutingContext>
{
  static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(GraphQLHandler.class);

  private static final String GRAPHQL_DATA = "data";
  private static final String GRAPHQL_ERRORS = "errors";

  // private final AsyncGraphQLExec m_asyncGraphQLExec;
  private final Provider<DatabaseContext> m_databaseContext;

  @Inject
  public GraphQLHandler(GraphQLSchema schema, Provider<DatabaseContext> databaseContext)
  {
    // Instrumentation instrumentation = new ChainedInstrumentation(asList(new TracingInstrumentation(),
    // new DataLoaderDispatcherInstrumentation(newOptions().includeStatistics(true))));
    // m_asyncGraphQLExec = AsyncGraphQLExec.create(GraphQL.newGraphQL(schema).instrumentation(instrumentation)
    // .queryExecutionStrategy(new AsyncExecutionStrategy()));
    m_databaseContext = databaseContext;
  }

  @Override
  public void handle(RoutingContext routingContext)
  {
    QueryParameters parameters = QueryParameters.from(routingContext);
    if (parameters.getQuery() == null)
    {
      routingContext.response().setStatusCode(HttpResponseStatus.BAD_REQUEST.code()).end("Must provide query");
      return;
    }

    // m_asyncGraphQLExec.executeQuery(parameters.getQuery(), parameters.getOperationName(), m_databaseContext.get(),
    // parameters.getVariables()).setHandler(queryResult -> {
    // if (queryResult.succeeded())
    // {
    // JsonObject json = queryResult.result();
    // routingContext.response()//
    // .putHeader(HttpHeaders.CONTENT_TYPE.toString(), "application/json; charset=utf-8") //
    // .setStatusCode(HttpResponseStatus.OK.code()) //
    // .end(new JsonObject().put(GRAPHQL_DATA, json).encode());
    // }
    // else
    // {
    // Map<String, Object> result = new HashMap<>();
    // result.put(GRAPHQL_DATA, null);
    // if (queryResult.cause() instanceof AsyncExecutionException)
    // {
    // AsyncExecutionException ex = (AsyncExecutionException) queryResult.cause();
    // LOG.error("Errors {}", ex.getErrors());
    // result.put(GRAPHQL_ERRORS, ex.getErrors());
    // }
    // else
    // {
    // if (queryResult.cause() != null)
    // {
    // LOG.error("Failed", queryResult.cause());
    // }
    // result.put(GRAPHQL_ERRORS, queryResult.cause() != null ? Arrays.asList(queryResult.cause())
    // : Arrays.asList(new Exception("Internal error")));
    // }
    // JsonObject errorResult = new JsonObject(result);
    // routingContext.response().setStatusCode(HttpResponseStatus.BAD_REQUEST.code()).end(errorResult.encode());
    // }
    // });
  }
}
