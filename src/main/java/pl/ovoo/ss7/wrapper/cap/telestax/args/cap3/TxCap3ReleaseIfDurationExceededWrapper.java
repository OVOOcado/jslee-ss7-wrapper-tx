/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args.cap3;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.AudibleIndicator;
import pl.ovoo.ss7.wrapper.cap.args.cap3.Cap3ReleaseIfDurationExceededWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.TxCap2ReleaseIfDurationExceededWrapper;

/**
 * TxCap3ReleaseIfDurationExceededWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap3ReleaseIfDurationExceededWrapper extends TxCap2ReleaseIfDurationExceededWrapper implements Cap3ReleaseIfDurationExceededWrapper {

    public TxCap3ReleaseIfDurationExceededWrapper(final AudibleIndicator audibleIndicator) {
        super(audibleIndicator);
    }

}
