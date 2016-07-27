package lemongrenade.core.storm;

import org.apache.storm.tuple.Tuple;
import io.latent.storm.rabbitmq.TupleToMessage;
import lemongrenade.core.models.LGPayload;
import lemongrenade.core.util.LGConstants;

public class CommandSinkScheme extends TupleToMessage {

    @Override
    protected byte[] extractBody(Tuple tuple) {
        LGPayload payload = (LGPayload) tuple.getValueByField(LGConstants.LG_COMMAND);
        return payload.toByteArray();
    }

    @Override
    protected String determineExchangeName(Tuple tuple) {
        return tuple.getStringByField("destination");
    }

}
