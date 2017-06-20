/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args.cap2;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.AudibleIndicator;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2ReleaseIfDurationExceededWrapper;

/**
 * OcCap2ReleaseIfDurationExceededWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2ReleaseIfDurationExceededWrapper implements Cap2ReleaseIfDurationExceededWrapper {

    private final AudibleIndicator audibleIndicator;

    public TxCap2ReleaseIfDurationExceededWrapper(final AudibleIndicator audibleIndicator) {
        this.audibleIndicator = audibleIndicator;
    }

    @Override
    public boolean getTone() {
        return audibleIndicator.getTone();
    }

    public AudibleIndicator getTxAudibleIndicator() {
        return audibleIndicator;
    }

    @Override
    public String toString() {
        return "TxCap2ReleaseIfDurationExceededWrapper [audibleIndicator=" + audibleIndicator + "]";
    }

}
