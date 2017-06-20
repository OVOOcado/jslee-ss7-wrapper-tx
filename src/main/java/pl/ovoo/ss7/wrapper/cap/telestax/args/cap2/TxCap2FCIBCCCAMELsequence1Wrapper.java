package pl.ovoo.ss7.wrapper.cap.telestax.args.cap2;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.FCIBCCCAMELsequence1;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2FCIBCCCAMELsequence1Wrapper;

/**
 * TxCap2FCIBCCCAMELsequence1Wrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2FCIBCCCAMELsequence1Wrapper implements Cap2FCIBCCCAMELsequence1Wrapper {

    private final FCIBCCCAMELsequence1 txFCIBCCCAMELsequence1;

    public TxCap2FCIBCCCAMELsequence1Wrapper(final FCIBCCCAMELsequence1 txFCIBCCCAMELsequence1) {
        this.txFCIBCCCAMELsequence1 = txFCIBCCCAMELsequence1;
    }

    public FCIBCCCAMELsequence1 getTxFCIBCCCAMELsequence1() {
        return txFCIBCCCAMELsequence1;
    }
}
