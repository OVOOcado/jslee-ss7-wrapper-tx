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

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwInfo;
import pl.ovoo.ss7.wrapper.map.args.MAPForwardingFeatureWrapper;
import pl.ovoo.ss7.wrapper.map.args.MAPForwardingInfoWrapper;

/**
 * TxMAPForwardingInfoWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxMAPForwardingInfoWrapper implements MAPForwardingInfoWrapper {

    private transient MAPForwardingFeatureWrapper[] mapForwardingFeatureWrappers = null;

    private final ExtForwInfo extForwInfo;

    public TxMAPForwardingInfoWrapper(final ExtForwInfo extForwInfo) {
        this.extForwInfo = extForwInfo;
    }

    @Override
    public MAPForwardingFeatureWrapper[] getForwardingFeatureList() {
        if (this.mapForwardingFeatureWrappers == null && extForwInfo.getForwardingFeatureList() != null
                && extForwInfo.getForwardingFeatureList().size() > 0) {
            MAPForwardingFeatureWrapper[] txMAPForwardingFeatures = new MAPForwardingFeatureWrapper[extForwInfo
                    .getForwardingFeatureList().size()];
            for (int i = 0; i < extForwInfo.getForwardingFeatureList().size(); i++) {
                final MAPForwardingFeatureWrapper ocMAPForwardingFeature = new TxMAPForwardingFeatureWrapper(
                        extForwInfo.getForwardingFeatureList().get(i));
                txMAPForwardingFeatures[i] = ocMAPForwardingFeature;
            }
            this.mapForwardingFeatureWrappers = txMAPForwardingFeatures;
        }
        return this.mapForwardingFeatureWrappers;
    }

    public ExtForwInfo getTxExtForwInfo() {
        return extForwInfo;
    }

    @Override
    public String toString() {
        return "TxMAPForwardingInfoWrapper [extForwInfo=" + extForwInfo + "]";
    }

}
