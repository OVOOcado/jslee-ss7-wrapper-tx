package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.indicator.NumberingPlan;
import org.mobicents.protocols.ss7.map.MAPParameterFactoryImpl;
import org.mobicents.protocols.ss7.map.api.MAPParameterFactory;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.AddressString;
import org.mobicents.protocols.ss7.map.api.primitives.IMSI;

import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import pl.ovoo.ss7.wrapper.common.args.AddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.args.IMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.common.telestax.TxIMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.common.telestax.TxRoutingInfoWrapper;
import pl.ovoo.ss7.wrapper.map.args.MtForwardShortMessageRequestWrapper;

/**
 * Created by karolsimka on 08.06.17.
 */
public class TxMtForwardShortMessageRequestArgWrapper implements MtForwardShortMessageRequestWrapper {
    private transient IMSIAddressWrapper imsiAddressWrapper = null;
    private transient ISDNAddressStringWrapper serviceCentreAddressOAWrapper = null;

    private IMSI imsi;
    private ISDNAddressString serviceCentreAddressOA;
    private String text;

    public TxMtForwardShortMessageRequestArgWrapper() {
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
            TxIMSIAddressWrapper txIMSIAddressWrapper = (TxIMSIAddressWrapper) imsi;
            this.imsi = txIMSIAddressWrapper.getTxImsi();
            this.imsiAddressWrapper = txIMSIAddressWrapper;
        }
    }

    @Override
    public AddressStringWrapper getServiceCentreAddressOA() {
        if (this.serviceCentreAddressOAWrapper == null && this.serviceCentreAddressOA != null) {
            this.serviceCentreAddressOAWrapper = new TxISDNAddressStringWrapperImpl(serviceCentreAddressOA);
        }
        return this.serviceCentreAddressOAWrapper;
    }

    public void setServiceCentreAddressOA(AddressStringWrapper serviceCentreAddressOA) {
        if (serviceCentreAddressOA == null) {
            this.serviceCentreAddressOA = null;
            this.serviceCentreAddressOAWrapper = null;
        } else {
            TxISDNAddressStringWrapperImpl txServiceCentreAddressOA = (TxISDNAddressStringWrapperImpl)serviceCentreAddressOA;
            this.serviceCentreAddressOA = txServiceCentreAddressOA.getTxAddress();
            this.serviceCentreAddressOAWrapper = txServiceCentreAddressOA;
            
        }
    }

    @Override
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public IMSI getTxIMSI() {
        return imsi;
    }

    public void setTxIMSI(IMSI imsi) {
        this.imsiAddressWrapper = null;
        this.imsi = imsi;
    }

    public void setTxServiceCentreAddressOA(ISDNAddressString serviceCentreAddressOA) {
        this.serviceCentreAddressOAWrapper = null;
        this.serviceCentreAddressOA = serviceCentreAddressOA;
    }

    public AddressString getTxServiceCentreAddressOA() {
        return serviceCentreAddressOA;
    }

    @Override
    public String toString() {
        return "TxMtForwardShortMessageRequestArgWrapper [imsi=" + imsi + ", serviceCentreAddressOA="
                + serviceCentreAddressOA + ", text=" + text + "]";
    }

}
