package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.FreeFormatData;
import pl.ovoo.ss7.wrapper.cap.args.FreeFormatDataWrapper;

/**
 * TxFreeFormatDataWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxFreeFormatDataWrapper implements FreeFormatDataWrapper {

    private final FreeFormatData txFreeFormatData;

    public TxFreeFormatDataWrapper(final FreeFormatData freeFormatData) {
        this.txFreeFormatData = freeFormatData;
    }

    public FreeFormatData getTxFreeFormatData() {
        return txFreeFormatData;
    }
}
