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

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwFeature;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtSSStatus;
import pl.ovoo.ss7.wrapper.common.args.AddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.tx.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.args.MAPForwardingFeatureWrapper;
import pl.ovoo.ss7.wrapper.map.args.MAPForwardingOptionsWrapper;

/**
 * TxMAPForwardingFeatureWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxMAPForwardingFeatureWrapper implements MAPForwardingFeatureWrapper {

    private transient MAPForwardingOptionsWrapper mapForwardingOptionsWrapper = null;
    private transient AddressStringWrapper addressStringWrapper = null;

    private ExtForwFeature extForwFeature;

    public TxMAPForwardingFeatureWrapper(final ExtForwFeature extForwFeature) {
        this.extForwFeature = extForwFeature;
    }

    @Override
    public MAPForwardingOptionsWrapper getForwardingOptions() {
        if (this.mapForwardingOptionsWrapper == null && this.extForwFeature.getForwardingOptions() != null) {
            mapForwardingOptionsWrapper = new TxMAPForwardingOptionsWrapper(extForwFeature.getForwardingOptions());
        }
        return mapForwardingOptionsWrapper;
    }

    @Override
    public AddressStringWrapper getForwardedToNumber() {
        if (this.addressStringWrapper == null && this.extForwFeature.getForwardedToNumber() != null) {
            this.addressStringWrapper = new TxISDNAddressStringWrapperImpl(extForwFeature.getForwardedToNumber());
        }
        return this.addressStringWrapper;
    }

    @Override
    public byte[] getCFStatus() {
        if (extForwFeature.getSsStatus() != null) {
            ExtSSStatus cfStatus = extForwFeature.getSsStatus();
            return cfStatus.getData();
        }
        return null;
    }

    /*
     * @Override public void setForwardingOptions(MAPForwardingOptionsWrapper
     * forwardingOptions) {
     * extForwFeature.setForwardingOptions(((TxMAPForwardingOptionsWrapper)
     * forwardingOptions).getTxExtForwOptions()); }
     * 
     * @Override public void setForwardedToNumber(AddressStringWrapper
     * forwardedToNumber) {
     * 
     * }
     */

    public ExtForwFeature getTxExtForwFeature() {
        return extForwFeature;
    }

    @Override
    public String toString() {
        return "TxMAPForwardingFeatureWrapper [extForwFeature=" + extForwFeature + "]";
    }

}
