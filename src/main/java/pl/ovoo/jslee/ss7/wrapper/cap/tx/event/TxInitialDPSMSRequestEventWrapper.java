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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.event;

import org.mobicents.protocols.ss7.cap.api.service.sms.InitialDPSMSRequest;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxInitialDPSMSArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPSMSArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.event.InitialDPSMSRequestEventWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxInitialDPSMSRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxInitialDPSMSRequestEventWrapper extends TxEventWrapper implements InitialDPSMSRequestEventWrapper {

    private final InitialDPSMSRequest initialDPSMSRequest;

    public TxInitialDPSMSRequestEventWrapper(final InitialDPSMSRequest initialDPSMSRequest, final ActivityContextInterface aci) {
        super(aci, initialDPSMSRequest);
        this.initialDPSMSRequest = initialDPSMSRequest;
    }

    @Override
    public InitialDPSMSArgWrapper getArgument() {
        final TxInitialDPSMSArgWrapper txInitialDPSMSArgWrapper = new TxInitialDPSMSArgWrapper();
        
        txInitialDPSMSArgWrapper.setTxCallingPartyNumber(initialDPSMSRequest.getCallingPartyNumber());
        txInitialDPSMSArgWrapper.setTxDestinationSubscriberNumber(initialDPSMSRequest.getDestinationSubscriberNumber());
        txInitialDPSMSArgWrapper.setTxEventTypeSMS(initialDPSMSRequest.getEventTypeSMS());
        if(initialDPSMSRequest.getSmsReferenceNumber() != null){
        	txInitialDPSMSArgWrapper.setTxSmsReferenceNumber(initialDPSMSRequest.getSmsReferenceNumber());
        }
        txInitialDPSMSArgWrapper.setTxLocationInformationMSC(initialDPSMSRequest.getLocationInformationMSC());
        txInitialDPSMSArgWrapper.setTxSmscAddress(initialDPSMSRequest.getSMSCAddress());
        txInitialDPSMSArgWrapper.setTxServiceKey(initialDPSMSRequest.getServiceKey());
        txInitialDPSMSArgWrapper.setTxMscAddress(initialDPSMSRequest.getMscAddress());
        txInitialDPSMSArgWrapper.setTxImsi(initialDPSMSRequest.getImsi());
        txInitialDPSMSArgWrapper.setTxTimeAndTimezone(initialDPSMSRequest.getTimeAndTimezone());
        
        return txInitialDPSMSArgWrapper;
    }
}
