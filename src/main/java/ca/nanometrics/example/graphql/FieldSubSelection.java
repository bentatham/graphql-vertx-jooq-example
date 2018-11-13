package ca.nanometrics.example.graphql;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import graphql.language.Field;
import graphql.language.Selection;
import graphql.schema.DataFetchingFieldSelectionSet;

public class FieldSubSelection
{
  private static final String SEP = FileSystems.getDefault().getSeparator();

  private final Set<String> m_flattenedFields;

  public FieldSubSelection(DataFetchingFieldSelectionSet selectionSet)
  {
    m_flattenedFields = new LinkedHashSet<>();
    Map<String, List<Field>> fieldMap = selectionSet.get();
    for (List<Field> fields : fieldMap.values())
    {
      traverseFields(fields, "");
    }
  }

  private void traverseFields(List<Field> fieldList, String parentField)
  {
    for (Field field : fieldList)
    {
      String fieldName = (!parentField.isEmpty() ? parentField + SEP : "") + field.getName();
      m_flattenedFields.add(fieldName);
      if (field.getSelectionSet() != null)
      {
        @SuppressWarnings("rawtypes") List<Selection> selections = field.getSelectionSet().getSelections();
        if (selections != null)
        {
          List<Field> subFields =
              selections.stream().filter(s -> s instanceof Field).map(f -> (Field) f).collect(Collectors.toList());

          traverseFields(subFields, fieldName);
        }
      }
    }
  }

  public boolean containsField(String fieldAddress)
  {
    if (fieldAddress == null || fieldAddress.isEmpty())
    {
      return false;
    }
    fieldAddress = fieldAddress.replace(".", SEP);
    PathMatcher globMatcher = FileSystems.getDefault().getPathMatcher("glob:" + fieldAddress);
    for (String flattenedField : m_flattenedFields)
    {
      if (flattenedField.equals(fieldAddress))
      {
        return true;
      }
      Path path = Paths.get(flattenedField);
      if (globMatcher.matches(path))
      {
        return true;
      }
    }
    return false;
  }
}
