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

package pl.ovoo.ss7.wrapper.map.tx.args;

import org.mobicents.protocols.ss7.map.MAPParameterFactoryImpl;
import org.mobicents.protocols.ss7.map.api.MAPParameterFactory;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;
import org.mobicents.protocols.ss7.map.api.service.callhandling.RoutingInfo;

import pl.ovoo.ss7.wrapper.common.args.IMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.args.RoutingInfoWrapper;
import pl.ovoo.ss7.wrapper.common.tx.TxIMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.tx.TxRoutingInfoWrapper;
import pl.ovoo.ss7.wrapper.map.args.SendRoutingInfoResponseWrapper;

/**
 * Created by karolsimka on 06.06.17.
 */
public class TxSendRoutingInfoResponseWrapper implements SendRoutingInfoResponseWrapper {

    private transient IMSIAddressWrapper imsiAddressWrapper = null;
    private transient RoutingInfoWrapper roamingAddresWrapper = null;

    private IMSI imsi;

    private RoutingInfo roamingAddress;

    public TxSendRoutingInfoResponseWrapper() {
        super();
    }

    @Override
    public IMSIAddressWrapper getImsi() {
        if (this.imsiAddressWrapper == null && this.imsi != null) {
            this.imsiAddressWrapper = new TxIMSIAddressWrapper(imsi);
        }
        return this.imsiAddressWrapper;
    }

    public void setImsi(IMSIAddressWrapper imsi) {
        if (imsi == null) {
            this.imsi = null;
            this.imsiAddressWrapper = null;
        } else {
            TxIMSIAddressWrapper txImsi = (TxIMSIAddressWrapper) imsi;
            this.imsi = txImsi.getTxImsi();
            this.imsiAddressWrapper = txImsi;
        }
    }

    @Override
    public RoutingInfoWrapper getRoutingInfo() {
        if (this.roamingAddresWrapper == null && this.roamingAddress != null) {
            this.roamingAddresWrapper = new TxRoutingInfoWrapper(roamingAddress);
        }
        return this.roamingAddresWrapper;
    }

    public void setRoutingInfo(RoutingInfoWrapper routingInfo) {
        if (routingInfo == null) {
            this.roamingAddress = null;
            this.roamingAddresWrapper = null;
        } else {
            TxRoutingInfoWrapper txRoutingInfo = (TxRoutingInfoWrapper) routingInfo;
            MAPParameterFactory factory = new MAPParameterFactoryImpl();

            ISDNAddressString roamingNumber = factory.createISDNAddressString(
                    AddressNature.getInstance(txRoutingInfo.getNatureOfAddress().getValue()),
                    NumberingPlan.getInstance(txRoutingInfo.getNumberingPlan().getValue()),
                    txRoutingInfo.getRoamingNumber());
            this.roamingAddresWrapper = txRoutingInfo;
            this.roamingAddress = factory.createRoutingInfo(roamingNumber);
        }
    }

    public RoutingInfo getTxRoamingAddress() {
        return roamingAddress;

    }

    public void setTxRoamingAddress(RoutingInfo  roamingAddress) {
        this.roamingAddress = roamingAddress;
        this.roamingAddresWrapper = null;
    }

    public IMSI getTxImsi() {
        return this.imsi;
    }

    public void setTxImsi(IMSI imsi) {
        this.imsi = imsi;
        this.imsiAddressWrapper = null;
    }

    @Override
    public String toString() {
        return "TxSendRoutingInfoResponseWrapper [imsi=" + imsi + ", roamingAddress=" + roamingAddress + "]";
    }

}
