package ca.nanometrics.example.graphql;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

/**
 * Graphql clients can send GET or POST HTTP requests. The spec does not make an explicit distinction, so this handles
 * both.
 */
public class QueryParameters
{
  private static final String QUERY = "query";
  private static final String OPERATION_NAME = "operationName";
  private static final String VARIABLES = "variables";

  private final String m_query;
  private final String m_operationName;
  private final Map<String, Object> m_variables;

  private QueryParameters(String query, String operationName, Map<String, Object> variables)
  {
    m_query = query;
    m_operationName = operationName;
    m_variables = variables;
  }

  public String getQuery()
  {
    return m_query;
  }

  public String getOperationName()
  {
    return m_operationName;
  }

  public Map<String, Object> getVariables()
  {
    return m_variables;
  }

  public static QueryParameters from(RoutingContext routingContext)
  {
    HttpServerRequest request = routingContext.request();
    if (request.method() == HttpMethod.POST)
    {
      JsonObject bodyJson = routingContext.getBodyAsJson();
      return new QueryParameters(//
          bodyJson.getString(QUERY), //
          bodyJson.getString(OPERATION_NAME), //
          toMap(bodyJson.getJsonObject(VARIABLES)));
    }
    return new QueryParameters(//
        request.getParam(QUERY), //
        request.getParam(OPERATION_NAME), //
        toMap(String.valueOf(request.getParam(VARIABLES))));
  }

  private static Map<String, Object> toMap(JsonObject variables)
  {
    return variables == null ? ImmutableMap.of() : variables.getMap();
  }

  static final Gson GSON = new GsonBuilder()
      // This is important because the graphql spec says that null values should be present
      .serializeNulls().create();

  public static Map<String, Object> toMap(String jsonStr)
  {
    if (jsonStr == null || jsonStr.trim().length() == 0)
    {
      return Collections.emptyMap();
    }
    // gson uses type tokens for generic input like Map<String,Object>
    Type type = new TypeToken<Map<String, Object>>()
    {
      // anonymous inner class
    }.getType();
    Map<String, Object> map = GSON.fromJson(jsonStr, type);
    return map == null ? Collections.emptyMap() : map;
  }
}
