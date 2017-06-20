/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtForwOptions;
import pl.ovoo.ss7.wrapper.map.args.ForwardingReason;
import pl.ovoo.ss7.wrapper.map.args.MAPForwardingOptionsWrapper;

/**
 * TxMAPForwardingOptionsWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxMAPForwardingOptionsWrapper implements MAPForwardingOptionsWrapper {

    private final ExtForwOptions extForwOptions;

    public TxMAPForwardingOptionsWrapper(final ExtForwOptions extForwOptions) {
        this.extForwOptions = extForwOptions;
    }

    @Override
    public ForwardingReason getForwardingReason() {
        if (extForwOptions.getExtForwOptionsForwardingReason() != null) {
            return ForwardingReason.valueOf(extForwOptions.getExtForwOptionsForwardingReason().getCode());
        }
        return null;
    }

    public ExtForwOptions getTxExtForwOptions() {
        return extForwOptions;
    }

    @Override
    public String toString() {
        return "TxMAPForwardingOptionsWrapper [extForwOptions=" + extForwOptions + "]";
    }

}
