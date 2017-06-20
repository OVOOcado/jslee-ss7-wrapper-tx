/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.BearerCapability;
import pl.ovoo.ss7.wrapper.cap.args.BearerCapWrapper;
import pl.ovoo.ss7.wrapper.cap.args.BearerCapabilityWrapper;

/**
 * TxBearerCapabilityWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxBearerCapabilityWrapper implements BearerCapabilityWrapper {

    private transient BearerCapWrapper bearerCapWrapper = null;

    private final BearerCapability bearerCapability;

    public TxBearerCapabilityWrapper(final BearerCapability bearerCapability) {
        this.bearerCapability = bearerCapability;
    }

    @Override
    public BearerCapWrapper getBearerCap() {
        if (this.bearerCapWrapper == null && bearerCapability.getBearerCap() != null) {
            this.bearerCapWrapper = new TxBearerCapWrapper(bearerCapability.getBearerCap());
        }
        return this.bearerCapWrapper;
    }

    public BearerCapability getTxBearerCapability() {
        return bearerCapability;
    }

    @Override
    public String toString() {
        return "TxBearerCapabilityWrapper [bearerCapability=" + bearerCapability + "]";
    }

}
