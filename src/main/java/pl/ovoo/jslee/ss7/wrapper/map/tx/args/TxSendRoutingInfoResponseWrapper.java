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

package pl.ovoo.jslee.ss7.wrapper.map.tx.args;

import org.mobicents.protocols.ss7.map.MAPParameterFactoryImpl;
import org.mobicents.protocols.ss7.map.api.MAPParameterFactory;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;
import org.mobicents.protocols.ss7.map.api.service.callhandling.ExtendedRoutingInfo;
import org.mobicents.protocols.ss7.map.api.service.callhandling.RoutingInfo;

import pl.ovoo.jslee.ss7.wrapper.common.args.ExtendedRoutingInfoWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.args.IMSIAddressWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.args.RoutingInfoWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxExtendedRoutingInfoWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxIMSIAddressWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxRoutingInfoWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.SendRoutingInfoResponseWrapper;


/**
 * Created by karolsimka on 06.06.17.
 */
public class TxSendRoutingInfoResponseWrapper implements SendRoutingInfoResponseWrapper {

    /** The imsi address wrapper. */
    private transient IMSIAddressWrapper imsiAddressWrapper = null;
    
    /** The roaming addres wrapper. */
    private transient ExtendedRoutingInfoWrapper extendedRoutingInfoWrapper = null;

    /** The imsi. */
    private IMSI imsi;

    /** The roaming address. */
    private ExtendedRoutingInfo extendedRoutingInfo;

    /**
     * Instantiates a new tx send routing info response wrapper.
     */
    public TxSendRoutingInfoResponseWrapper() {
        super();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.SendRoutingInfoResponseWrapper#getImsi()
     */
    @Override
    public IMSIAddressWrapper getImsi() {
        if (this.imsiAddressWrapper == null && this.imsi != null) {
            this.imsiAddressWrapper = new TxIMSIAddressWrapper(imsi);
        }
        return this.imsiAddressWrapper;
    }

    /**
     * Sets the imsi.
     *
     * @param imsi the new imsi
     */
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

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.args.SendRoutingInfoResponseWrapper#getRoutingInfo()
     */
    @Override
    public ExtendedRoutingInfoWrapper getExtendedRoutingInfo() {
        if (this.extendedRoutingInfoWrapper == null && this.extendedRoutingInfo != null) {
            this.extendedRoutingInfoWrapper = new TxExtendedRoutingInfoWrapper(extendedRoutingInfo);
        }
        return this.extendedRoutingInfoWrapper;
    }

    /**
     * Sets the routing info.
     *
     * @param routingInfo the new routing info
     */
    public void setExtendedRoutingInfo(ExtendedRoutingInfoWrapper extendedRoutingInfo) {
        if (extendedRoutingInfo == null) {
            this.extendedRoutingInfo = null;
            this.extendedRoutingInfoWrapper = null;
        } else {
            TxExtendedRoutingInfoWrapper txExtendedRoutingInfo = (TxExtendedRoutingInfoWrapper) extendedRoutingInfo;
            MAPParameterFactory factory = new MAPParameterFactoryImpl();

            if(extendedRoutingInfo.getRoutingInfo()!= null){
            	TxRoutingInfoWrapper txRoutingInfo = (TxRoutingInfoWrapper)txExtendedRoutingInfo.getRoutingInfo();
                this.extendedRoutingInfo =  factory.createExtendedRoutingInfo(txRoutingInfo.getTxRoutingInfo());
            }
            this.extendedRoutingInfoWrapper = extendedRoutingInfo;
        }
    }

    /**
     * Gets the tx roaming address.
     *
     * @return the tx roaming address
     */
    public ExtendedRoutingInfo getTxExtendedRoutingInfo() {
        return extendedRoutingInfo;

    }

    /**
     * Sets the tx roaming address.
     *
     * @param roamingAddress the new tx roaming address
     */
    public void setTxExtendedRoutingInfo(ExtendedRoutingInfo  extendedRoutingInfo) {
        this.extendedRoutingInfo = extendedRoutingInfo;
        this.extendedRoutingInfoWrapper = null;
    }

    /**
     * Gets the tx imsi.
     *
     * @return the tx imsi
     */
    public IMSI getTxImsi() {
        return this.imsi;
    }

    /**
     * Sets the tx imsi.
     *
     * @param imsi the new tx imsi
     */
    public void setTxImsi(IMSI imsi) {
        this.imsi = imsi;
        this.imsiAddressWrapper = null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxSendRoutingInfoResponseWrapper [imsi=" + imsi + ", extendedRoutingInfo=" + extendedRoutingInfo + "]";
    }

}
