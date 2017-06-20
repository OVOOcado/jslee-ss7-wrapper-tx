package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import pl.ovoo.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.args.SmDeliveryOutcome;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.args.SmsDeliverTpduWrapper;

/**
 * Created by karolsimka on 12.06.17.
 */
public class TxSmsDeliverTpduWrapper implements SmsDeliverTpduWrapper {

    private ISDNAddressString msisdn;

    private org.mobicents.protocols.ss7.map.api.service.sms.SMDeliveryOutcome smDeliveryOutcome;

    public TxSmsDeliverTpduWrapper() {super();}

    @Override
    public ISDNAddressStringWrapper getMsisdn(){
        return new TxISDNAddressStringWrapperImpl(msisdn);
    }

    public void setMsisdn(ISDNAddressStringWrapper msisdn){
        TxISDNAddressStringWrapperImpl txMsisdn = (TxISDNAddressStringWrapperImpl)msisdn;
        this.msisdn = txMsisdn.getTxAddress();
    }

    @Override
    public SmDeliveryOutcome getOutcome() {
        return SmDeliveryOutcome.valueOf(this.smDeliveryOutcome.getCode());
    }

    public void setSmDeliveryOutcome(pl.ovoo.ss7.wrapper.common.args.SmDeliveryOutcome smDeliveryOutcome){
        this.smDeliveryOutcome = org.mobicents.protocols.ss7.map.api.service.sms.SMDeliveryOutcome.getInstance(smDeliveryOutcome.getValue());
    }
}
