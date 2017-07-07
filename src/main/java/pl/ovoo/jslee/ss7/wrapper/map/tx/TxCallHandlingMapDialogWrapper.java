/*
 * JSLEE SS7 Wrapper Tx
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the JSLEE SS7 Wrapper Tx.
 *
 * JSLEE SS7 Wrapper Tx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JSLEE SS7 Wrapper Tx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.ovoo.jslee.ss7.wrapper.map.tx;

import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.service.callhandling.InterrogationType;
import org.mobicents.protocols.ss7.map.api.service.callhandling.MAPDialogCallHandling;
import org.mobicents.slee.resource.map.service.callhandling.wrappers.MAPDialogCallHandlingWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxSendRoutingInfoRequestArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxSendRoutingInfoResponseWrapper;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxIMSIAddressWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxRoutingInfoWrapper;
import pl.ovoo.ss7.wrapper.map.CallHandlingMapDialogWrapper;
import pl.ovoo.ss7.wrapper.map.args.SendRoutingInfoRequestArgWrapper;
import pl.ovoo.ss7.wrapper.map.args.SendRoutingInfoResponseWrapper;

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
            if(txImsi != null && txRoutingInfo != null) {
                ((MAPDialogCallHandlingWrapper) dialog).addSendRoutingInformationResponse(invoke,
                        txImsi.getTxImsi(),
                        null,
                        txRoutingInfo.getTxRoutingInfo());
            }
        } catch (MAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

}
