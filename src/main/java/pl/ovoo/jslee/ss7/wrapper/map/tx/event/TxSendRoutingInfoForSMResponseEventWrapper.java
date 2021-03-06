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

import org.mobicents.protocols.ss7.map.api.service.sms.SendRoutingInfoForSMResponse;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxIMSIAddressWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxISDNAddressStringWrapperImpl;
import pl.ovoo.jslee.ss7.wrapper.map.args.SendRoutingInfoForSMResponseWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.event.SendRoutingInfoForSMResponseEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxSendRoutingInfoForSMResponseWrapper;

import javax.slee.ActivityContextInterface;


/**
 * Created by karolsimka on 07.06.17.
 */
public class TxSendRoutingInfoForSMResponseEventWrapper extends TxMapEventWrapper implements SendRoutingInfoForSMResponseEventWrapper {

    /** The send routing info for sm response. */
    private final SendRoutingInfoForSMResponse sendRoutingInfoForSMResponse;

    /**
     * Instantiates a new tx send routing info for sm response event wrapper.
     *
     * @param sendRoutingInfoForSMResponse the send routing info for sm response
     * @param aci the aci
     */
    public TxSendRoutingInfoForSMResponseEventWrapper(final SendRoutingInfoForSMResponse sendRoutingInfoForSMResponse, final ActivityContextInterface aci) {
        super(aci);
        this.sendRoutingInfoForSMResponse = sendRoutingInfoForSMResponse;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.event.SendRoutingInfoForSMResponseEventWrapper#getArgument()
     */
    @Override
    public SendRoutingInfoForSMResponseWrapper getArgument() {
        TxSendRoutingInfoForSMResponseWrapper sri = new TxSendRoutingInfoForSMResponseWrapper();
        sri.setImsi(new TxIMSIAddressWrapper(sendRoutingInfoForSMResponse.getIMSI()));
        sri.setMscAddress(new TxISDNAddressStringWrapperImpl(sendRoutingInfoForSMResponse.getLocationInfoWithLMSI().getNetworkNodeNumber()));
        return sri;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.event.MapEventWrapper#getInvokeId()
     */
    @Override
    public long getInvokeId() {
        return sendRoutingInfoForSMResponse.getInvokeId();
    }
}
