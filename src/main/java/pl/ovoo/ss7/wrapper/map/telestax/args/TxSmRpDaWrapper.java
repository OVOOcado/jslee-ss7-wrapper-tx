package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
import pl.ovoo.ss7.wrapper.common.args.IMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxIMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.map.args.SmRpDaWrapper;

/**
 * Created by karolsimka on 03.07.17.
 */
public class TxSmRpDaWrapper implements SmRpDaWrapper {

    private transient IMSIAddressWrapper imsiAddressWrapper = null;

    private IMSI imsi;

    public TxSmRpDaWrapper() {super();}

    @Override
    public IMSIAddressWrapper getIMSI() {
        if (this.imsiAddressWrapper == null && this.imsi != null) {
            this.imsiAddressWrapper = new TxIMSIAddressWrapper(imsi);
        }
        return this.imsiAddressWrapper;
    }

    public void setIMSI(IMSIAddressWrapper imsi) {
        if (imsi == null) {
            this.imsi = null;
            this.imsiAddressWrapper = null;
        } else {
            TxIMSIAddressWrapper txImsi = (TxIMSIAddressWrapper) imsi;
            this.imsi = txImsi.getTxImsi();
            this.imsiAddressWrapper = txImsi;
        }
    }

    public IMSI getTxImsi() {
        return this.imsi;
    }

    public void setTxImsi(IMSI imsi) {
        this.imsi = imsi;
        this.imsiAddressWrapper = null;
    }

    @Override
    public String toString() {
        return "TxSmRpDaWrapper [IMSI=" + imsi + "]";
    }
}
