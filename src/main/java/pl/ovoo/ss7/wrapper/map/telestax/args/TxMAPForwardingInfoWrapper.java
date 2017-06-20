/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

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
