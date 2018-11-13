package ca.nanometrics.util.jooq.converter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.jooq.Converter;

public class InstantLocalDateConverter implements Converter<LocalDate, Instant>
{

  @Override
  public Instant from(LocalDate date)
  {
    if (date == null)
    {
      return null;
    }
    return date.atStartOfDay().toInstant(ZoneOffset.UTC);
  }

  @Override
  public LocalDate to(Instant instant)
  {
    if (instant == null)
    {
      return null;
    }
    return LocalDateTime.ofInstant(instant, ZoneOffset.UTC).toLocalDate();
  }

  @Override
  public Class<LocalDate> fromType()
  {
    return LocalDate.class;
  }

  @Override
  public Class<Instant> toType()
  {
    return Instant.class;
  }
}
