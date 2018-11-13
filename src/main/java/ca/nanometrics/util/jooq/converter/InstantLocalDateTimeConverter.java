package ca.nanometrics.util.jooq.converter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.jooq.Converter;

public class InstantLocalDateTimeConverter implements Converter<LocalDateTime, Instant>
{

  @Override
  public Instant from(LocalDateTime localDateTime)
  {
    if (localDateTime == null)
    {
      return null;
    }
    return localDateTime.toInstant(ZoneOffset.UTC);
  }

  @Override
  public LocalDateTime to(Instant instant)
  {
    if (instant == null)
    {
      return null;
    }
    return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
  }

  @Override
  public Class<LocalDateTime> fromType()
  {
    return LocalDateTime.class;
  }

  @Override
  public Class<Instant> toType()
  {
    return Instant.class;
  }
}
