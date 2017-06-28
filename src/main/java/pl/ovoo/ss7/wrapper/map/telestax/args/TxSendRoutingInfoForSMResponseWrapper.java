package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import pl.ovoo.ss7.wrapper.common.args.IMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxIMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.args.SendRoutingInfoForSMResponseWrapper;

/**
 * Created by karolsimka on 07.06.17.
 */
public class TxSendRoutingInfoForSMResponseWrapper implements SendRoutingInfoForSMResponseWrapper {

    private transient IMSIAddressWrapper imsiAddressWrapper = null;
    private transient ISDNAddressStringWrapper mscAddressWrapper = null;
    private transient ISDNAddressStringWrapper sgsnAddressWrapper = null;

    private IMSI imsi;
    private ISDNAddressString mscAddress;
    private ISDNAddressString sgsnAddress;

    public TxSendRoutingInfoForSMResponseWrapper() {
        super();
    }

    @Override
    public IMSIAddressWrapper getIMSI() {
        if (this.imsiAddressWrapper == null && this.imsi != null) {
            this.imsiAddressWrapper = new TxIMSIAddressWrapper(imsi);
        }
        return this.imsiAddressWrapper;
    }

    public void setImsi(IMSIAddressWrapper imsi) {
        if (imsi == null) {
            this.imsi = null;
            this.imsiAddressWrapper = null;
        } else {
            TxIMSIAddressWrapper txImsi = (TxIMSIAddressWrapper) imsi;
            this.imsi = txImsi.getTxImsi();
            this.imsiAddressWrapper = txImsi;
        }
    }

    @Override
    public ISDNAddressStringWrapper getMscAddress() {
        if (this.mscAddressWrapper == null && this.mscAddress != null) {
            this.mscAddressWrapper = new TxISDNAddressStringWrapperImpl(mscAddress);
        }
        return this.mscAddressWrapper;
    }

    public void setMscAddress(ISDNAddressStringWrapper mscAddress) {
        if (mscAddress == null) {
            this.mscAddress = null;
            this.mscAddressWrapper = null;
        } else {
            TxISDNAddressStringWrapperImpl txMscAddress = (TxISDNAddressStringWrapperImpl) mscAddress;
            this.mscAddress = txMscAddress.getTxAddress();
            this.mscAddressWrapper = txMscAddress;
        }
    }

    public IMSI getTxImsi() {
        return imsi;
    }

    public void setTxImsi(IMSI imsi) {
        this.imsi = imsi;
        this.imsiAddressWrapper = null;
    }

    public ISDNAddressString getTxMscAddress() {
        return mscAddress;
    }

    public void setTxMscAddress(ISDNAddressString mscAddress) {
        this.mscAddress = mscAddress;
        this.mscAddressWrapper = null;
    }
//
//    @Override
//    public ISDNAddressStringWrapper getSgsnAddress() {
//        if (this.sgsnAddressWrapper == null && this.sgsnAddress != null) {
//            this.sgsnAddressWrapper = new TxISDNAddressStringWrapperImpl(sgsnAddress);
//        }
//        return this.sgsnAddressWrapper;
//    }
//
//    public void setSgsnAddress(ISDNAddressStringWrapper sgsnAddress) {
//        if (sgsnAddress == null) {
//            this.sgsnAddress = null;
//            this.sgsnAddressWrapper = null;
//        } else {
//            TxISDNAddressStringWrapperImpl txSgsnAddress = (TxISDNAddressStringWrapperImpl) mscAddress;
//            this.mscAddress = txMscAddress.getTxAddress();
//            this.mscAddressWrapper = txMscAddress;
//        }
//    }
//
//    public ISDNAddressString getTxSgsnAddress() {
//        return mscAddress;
//    }
//
//    public void setTxSgsnAddress(ISDNAddressString mscAddress) {
//        this.mscAddress = mscAddress;
//        this.mscAddressWrapper = null;
//    }

    @Override
    public String toString() {
        return "TxSendRoutingInfoForSMResponseWrapper [imsi=" + imsi + ", mscAddress=" + mscAddress + "]";
    }

}
