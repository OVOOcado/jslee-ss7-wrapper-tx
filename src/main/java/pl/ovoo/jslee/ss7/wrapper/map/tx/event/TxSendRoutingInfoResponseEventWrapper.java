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

import org.mobicents.protocols.ss7.map.api.service.callhandling.SendRoutingInformationResponse;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxIMSIAddressWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxRoutingInfoWrapper;
import pl.ovoo.ss7.wrapper.map.args.SendRoutingInfoResponseWrapper;
import pl.ovoo.ss7.wrapper.map.event.SendRoutingInfoResponseEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxSendRoutingInfoResponseWrapper;

import javax.slee.ActivityContextInterface;

/**
 * Created by karolsimka on 07.06.17.
 */
public class TxSendRoutingInfoResponseEventWrapper extends TxMapEventWrapper implements SendRoutingInfoResponseEventWrapper{

    private final SendRoutingInformationResponse sendRoutingInformationResponse;

    public TxSendRoutingInfoResponseEventWrapper(final SendRoutingInformationResponse sendRoutingInformationResponse, final ActivityContextInterface aci) {
        super(aci);
        this.sendRoutingInformationResponse = sendRoutingInformationResponse;
    }

    @Override
    public SendRoutingInfoResponseWrapper getArgument() {
        TxSendRoutingInfoResponseWrapper sri = new TxSendRoutingInfoResponseWrapper();
        sri.setImsi(new TxIMSIAddressWrapper(sendRoutingInformationResponse.getIMSI()));
        sri.setRoutingInfo(new TxRoutingInfoWrapper(sendRoutingInformationResponse.getRoutingInfo2()));
        return sri;
    }

    @Override
    public long getInvokeId() {
        return sendRoutingInformationResponse.getInvokeId();
    }
}
