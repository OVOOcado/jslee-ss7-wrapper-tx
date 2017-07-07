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

package pl.ovoo.ss7.wrapper.map.telestax.event;

import org.mobicents.protocols.ss7.map.api.service.callhandling.SendRoutingInformationRequest;

import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.args.SendRoutingInfoRequestArgWrapper;
import pl.ovoo.ss7.wrapper.map.event.SendRoutingInfoRequestEventWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxSendRoutingInfoRequestArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxInsertSubscriberDataRequestEventWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxSendRoutingInfoRequestEventWrapper extends TxMapEventWrapper implements SendRoutingInfoRequestEventWrapper {

	private final SendRoutingInformationRequest sendRoutingInformationRequest;

    public TxSendRoutingInfoRequestEventWrapper(final SendRoutingInformationRequest sendRoutingInformationRequest, final ActivityContextInterface aci) {
        super(aci);
        this.sendRoutingInformationRequest = sendRoutingInformationRequest;
    }

    @Override
    public SendRoutingInfoRequestArgWrapper getArgument() {
        TxSendRoutingInfoRequestArgWrapper sri = new TxSendRoutingInfoRequestArgWrapper();
        sri.setMsisdn(new TxISDNAddressStringWrapperImpl(sendRoutingInformationRequest.getMsisdn()));
    	return sri;
    }
    
    @Override
    public long getInvokeId(){
    	return sendRoutingInformationRequest.getInvokeId();
    }
}
