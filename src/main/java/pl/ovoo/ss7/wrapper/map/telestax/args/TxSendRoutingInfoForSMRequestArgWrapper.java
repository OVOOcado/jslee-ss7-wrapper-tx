package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.primitives.AddressString;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import pl.ovoo.ss7.wrapper.common.args.AddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.args.SendRoutingInfoForSMRequestArgWrapper;

/**
 * Created by karolsimka on 07.06.17.
 */
public class TxSendRoutingInfoForSMRequestArgWrapper implements SendRoutingInfoForSMRequestArgWrapper {
    private transient ISDNAddressStringWrapper isdnAddressStringWrapper = null;
    private transient AddressStringWrapper addressStringWrapper = null;

    private ISDNAddressString msisdn;
    private AddressString scAddress;

    public TxSendRoutingInfoForSMRequestArgWrapper() {
        super();
    }

    @Override
    public ISDNAddressStringWrapper getMsisdn() {
        if (this.isdnAddressStringWrapper == null && this.msisdn != null) {
            this.isdnAddressStringWrapper = new TxISDNAddressStringWrapperImpl(msisdn);
        }
        return this.isdnAddressStringWrapper;
    }

    public void setMsisdn(ISDNAddressStringWrapper msisdn) {
        if (msisdn == null) {
            this.msisdn = null;
            this.isdnAddressStringWrapper = null;
        }else {
            TxISDNAddressStringWrapperImpl txMsisdn = (TxISDNAddressStringWrapperImpl) msisdn;
            this.msisdn = txMsisdn.getTxAddress();
            this.isdnAddressStringWrapper = txMsisdn;
        }
    }

    public ISDNAddressString getTxMsisdn() {
        return this.msisdn;
    }

    public void setTxMsisdn(ISDNAddressString msisdn) {
        this.msisdn = msisdn;
    }

    public void setScAddress(AddressStringWrapper scAddress) {
        if (scAddress == null) {
            this.scAddress = null;
            this.addressStringWrapper = null;
        }else {
            TxAddressStringWrapperImpl txScAdddress = (TxAddressStringWrapperImpl) scAddress;
            this.scAddress = txScAdddress.getTxAddress();
            this.addressStringWrapper = txScAdddress;
        }
    }
    public AddressStringWrapper getScAddress() {
        if (this.addressStringWrapper == null && this.scAddress != null) {
            this.addressStringWrapper = new TxAddressStringWrapperImpl(scAddress);
        }
        return this.addressStringWrapper;
    }

    public AddressString getTxScAddress() {
        return this.scAddress;
    }

    public void setTxScAddress(AddressString scAddress) {
        this.scAddress = scAddress;
    }

    @Override
    public String toString() {
        return "TxSendRoutingInfoForSMRequestArgWrapper [msisdn=" + msisdn + "]";
    }


}
