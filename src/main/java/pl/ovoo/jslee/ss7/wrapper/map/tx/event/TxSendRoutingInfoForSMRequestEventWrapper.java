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

import org.mobicents.protocols.ss7.map.api.service.sms.SendRoutingInfoForSMRequest;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxISDNAddressStringWrapperImpl;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxSendRoutingInfoForSMRequestArgWrapper;
import pl.ovoo.ss7.wrapper.map.args.SendRoutingInfoForSMRequestArgWrapper;
import pl.ovoo.ss7.wrapper.map.event.SendRoutingInfoForSMRequestEventWrapper;

import javax.slee.ActivityContextInterface;

/**
 * Created by karolsimka on 07.06.17.
 */
public class TxSendRoutingInfoForSMRequestEventWrapper extends TxMapEventWrapper implements SendRoutingInfoForSMRequestEventWrapper {

    private final SendRoutingInfoForSMRequest sendRoutingInfoForSMRequest;

    public TxSendRoutingInfoForSMRequestEventWrapper(final SendRoutingInfoForSMRequest sendRoutingInfoForSMRequest, final ActivityContextInterface aci) {
        super(aci);
        this.sendRoutingInfoForSMRequest = sendRoutingInfoForSMRequest;
    }

    @Override
    public SendRoutingInfoForSMRequestArgWrapper getArgument() {
        TxSendRoutingInfoForSMRequestArgWrapper sri = new TxSendRoutingInfoForSMRequestArgWrapper();
        sri.setMsisdn(new TxISDNAddressStringWrapperImpl(sendRoutingInfoForSMRequest.getMsisdn()));
        return sri;
    }

    @Override
    public long getInvokeId() {
        return sendRoutingInfoForSMRequest.getInvokeId();
    }
}
