package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import pl.ovoo.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.args.SmRpOaWrapper;

/**
 * Created by karolsimka on 03.07.17.
 */
public class TxSmRpOaWrapper implements SmRpOaWrapper {

    private transient ISDNAddressStringWrapper serviceCentreAddressOaWrapper = null;

    private ISDNAddressString serviceCentreAddressOa;

    public TxSmRpOaWrapper(){super();}

    @Override
    public ISDNAddressStringWrapper getServiceCentreAddressOA() {
        if (this.serviceCentreAddressOaWrapper == null && this.serviceCentreAddressOa != null) {
            this.serviceCentreAddressOaWrapper = new TxISDNAddressStringWrapperImpl(serviceCentreAddressOa);
        }
        return this.serviceCentreAddressOaWrapper;
    }

    public void setServiceCentreAddressOa(ISDNAddressStringWrapper serviceCentreAddressOa){
        if (serviceCentreAddressOa == null) {
            this.serviceCentreAddressOa = null;
            this.serviceCentreAddressOaWrapper = null;
        } else {
            TxISDNAddressStringWrapperImpl txMsisdn = (TxISDNAddressStringWrapperImpl) serviceCentreAddressOa;
            this.serviceCentreAddressOa = txMsisdn.getTxAddress();
            this.serviceCentreAddressOaWrapper = txMsisdn;
        }
    }

    public ISDNAddressString getTxServiceCentreAddressOa() {
        return this.serviceCentreAddressOa;
    }

    public void setTxServiceCentreAddressOa(ISDNAddressString serviceCentreAddressOa) {
        this.serviceCentreAddressOa = serviceCentreAddressOa;
        this.serviceCentreAddressOaWrapper = null;

    }

    @Override
    public String toString() {
        return "TxSmRpOaWrapper [serviceCentreAddressOA=" + serviceCentreAddressOa + "]";
    }
}
