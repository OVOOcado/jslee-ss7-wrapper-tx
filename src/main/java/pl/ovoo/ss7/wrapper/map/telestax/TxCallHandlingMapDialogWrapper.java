/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax;

import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.service.callhandling.InterrogationType;
import org.mobicents.protocols.ss7.map.api.service.callhandling.MAPDialogCallHandling;
import org.mobicents.protocols.ss7.map.api.service.sms.MAPDialogSms;
import org.mobicents.slee.resource.map.service.callhandling.wrappers.MAPDialogCallHandlingWrapper;
import org.mobicents.slee.resource.map.service.sms.wrappers.MAPDialogSmsWrapper;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.common.telestax.TxIMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxRoutingInfoWrapper;
import pl.ovoo.ss7.wrapper.map.CallHandlingMapDialogWrapper;
import pl.ovoo.ss7.wrapper.map.args.SendRoutingInfoForSMRequestArgWrapper;
import pl.ovoo.ss7.wrapper.map.args.SendRoutingInfoForSMResponseWrapper;
import pl.ovoo.ss7.wrapper.map.args.SendRoutingInfoRequestArgWrapper;
import pl.ovoo.ss7.wrapper.map.args.SendRoutingInfoResponseWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxSendRoutingInfoRequestArgWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxSendRoutingInfoResponseWrapper;

/**
 * TxCallHandlingMapDialogWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCallHandlingMapDialogWrapper extends TxMapDialogWrapperImpl implements CallHandlingMapDialogWrapper {
    private MAPDialogCallHandling dialog;


    public TxCallHandlingMapDialogWrapper(final MAPDialogCallHandling dialog) {
        super(dialog);
        this.dialog = dialog;
    }
    
    @Override
    public int sendSendRoutingInfoRequest(long sriTimeout, SendRoutingInfoRequestArgWrapper arg) throws Ss7WrapperException{
        try {
            TxSendRoutingInfoRequestArgWrapper txArg = (TxSendRoutingInfoRequestArgWrapper)arg;
            return dialog.addSendRoutingInformationRequest(
                    (int)sriTimeout, 
                    txArg.getTxMsisdn(), 
                    null, 0, InterrogationType.basicCall, false, null,
                    txArg.getTxGmscAddress(),
                    null, null, null, null, null, false, null, null, false, null, null, null, false, null, false, false, false, false, null, null, null, false, null).intValue();

        } catch (MAPException e) {
            throw new Ss7WrapperException(e);
        }
    }
    
    @Override
    public void sendSendRoutingInfoResponse(long invoke, SendRoutingInfoResponseWrapper arg) throws Ss7WrapperException{
        try {
            TxSendRoutingInfoResponseWrapper txArg = (TxSendRoutingInfoResponseWrapper)arg;
            TxIMSIAddressWrapper txImsi = null;
            if (txArg.getImsi() != null){
                txImsi = (TxIMSIAddressWrapper)txArg.getImsi();
            }
            TxRoutingInfoWrapper txRoutingInfo = null;
            if (txArg.getRoutingInfo() != null){
                txRoutingInfo = (TxRoutingInfoWrapper)txArg.getRoutingInfo();
            }
            
            ((MAPDialogCallHandlingWrapper) dialog).addSendRoutingInformationResponse(invoke,
                    txImsi.getTxImsi(), 
                    null,
                    txRoutingInfo.getTxRoutingInfo());
        } catch (MAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

}
