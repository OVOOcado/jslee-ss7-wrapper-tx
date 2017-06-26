package pl.ovoo.ss7.wrapper.map.telestax;

import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.service.callhandling.MAPDialogCallHandling;
import org.mobicents.protocols.ss7.map.api.service.sms.MAPDialogSms;
import org.mobicents.slee.resource.map.service.sms.wrappers.MAPDialogSmsWrapper;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.common.telestax.TxIMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxRoutingInfoWrapper;
import pl.ovoo.ss7.wrapper.map.SMSMapDialogWrapper;
import pl.ovoo.ss7.wrapper.map.args.SendRoutingInfoForSMRequestArgWrapper;
import pl.ovoo.ss7.wrapper.map.args.SendRoutingInfoForSMResponseWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMAPLocationInformationWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxSendRoutingInfoForSMRequestArgWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxSendRoutingInfoForSMResponseWrapper;

/**
 * Created by karolsimka on 26.06.17.
 */
public class TxSMSMapDialogWrapper  extends TxMapDialogWrapperImpl implements SMSMapDialogWrapper {

    private MAPDialogSms dialog;

    public TxSMSMapDialogWrapper(final MAPDialogSms dialog) {
        super(dialog);
        this.dialog = dialog;
    }

    @Override
    public int sendSendRoutingInfoForSMRequest(long sriTimeout, SendRoutingInfoForSMRequestArgWrapper arg) throws Ss7WrapperException {
        try {
            TxSendRoutingInfoForSMRequestArgWrapper txArg = (TxSendRoutingInfoForSMRequestArgWrapper) arg;
            return dialog.addSendRoutingInfoForSMRequest((int) sriTimeout, txArg.getTxMsisdn(),false,txArg.getTxScAddress(),null,false,null,null,null).intValue();
        }catch(MAPException e){
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public void sendSendRoutingInfoForSMResponse(long invoke, SendRoutingInfoForSMResponseWrapper arg) throws Ss7WrapperException {
        try{
            TxSendRoutingInfoForSMResponseWrapper txArg = (TxSendRoutingInfoForSMResponseWrapper) arg;
            TxIMSIAddressWrapper txImsi = null;
            if(txArg.getIMSI()!= null){
                txImsi = (TxIMSIAddressWrapper) txArg.getIMSI();
            }

            //TODO check how to pass LocationInfoWithLMSI

            ((MAPDialogSmsWrapper) dialog).addSendRoutingInfoForSMResponse(invoke,txImsi.getTxImsi(),null,null,false);
        }catch(MAPException e){
            throw new Ss7WrapperException(e);
        }
    }
}
