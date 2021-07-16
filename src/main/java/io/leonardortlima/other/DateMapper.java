package io.leonardortlima.other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DateMapper {

    @Inject
    public DateMapper() {

    }

    public String asString(Date date) {
        return date != null ? new SimpleDateFormat( "yyyy" ).format( date ) : null;
    }

    public Date asDate(String date) {
        try {
            return date != null ? new SimpleDateFormat( "yyyy" ).parse( date ) : null;
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
    }
}
