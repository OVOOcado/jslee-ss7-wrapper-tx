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

package pl.ovoo.jslee.ss7.wrapper.map.tx.event;

import org.mobicents.protocols.ss7.map.api.service.callhandling.SendRoutingInformationRequest;

import pl.ovoo.jslee.ss7.wrapper.common.tx.TxISDNAddressStringWrapperImpl;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxSendRoutingInfoRequestArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.SendRoutingInfoRequestArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.event.SendRoutingInfoRequestEventWrapper;

import javax.slee.ActivityContextInterface;


/**
 * TxInsertSubscriberDataRequestEventWrapper.
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxSendRoutingInfoRequestEventWrapper extends TxMapEventWrapper implements SendRoutingInfoRequestEventWrapper {

	/** The send routing information request. */
	private final SendRoutingInformationRequest sendRoutingInformationRequest;

    /**
     * Instantiates a new tx send routing info request event wrapper.
     *
     * @param sendRoutingInformationRequest the send routing information request
     * @param aci the aci
     */
    public TxSendRoutingInfoRequestEventWrapper(final SendRoutingInformationRequest sendRoutingInformationRequest, final ActivityContextInterface aci) {
        super(aci);
        this.sendRoutingInformationRequest = sendRoutingInformationRequest;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.event.SendRoutingInfoRequestEventWrapper#getArgument()
     */
    @Override
    public SendRoutingInfoRequestArgWrapper getArgument() {
        TxSendRoutingInfoRequestArgWrapper sri = new TxSendRoutingInfoRequestArgWrapper();
        sri.setMsisdn(new TxISDNAddressStringWrapperImpl(sendRoutingInformationRequest.getMsisdn()));
    	return sri;
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.event.MapEventWrapper#getInvokeId()
     */
    @Override
    public long getInvokeId(){
    	return sendRoutingInformationRequest.getInvokeId();
    }
}
