/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtBasicServiceCode;
import pl.ovoo.ss7.wrapper.cap.args.ExtBasicServiceCodeWrapper;
import pl.ovoo.ss7.wrapper.cap.args.ExtBearerServiceCodeWrapper;
import pl.ovoo.ss7.wrapper.cap.args.ExtTeleserviceCodeWrapper;

/**
 * TxExtBasicServiceCodeWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxExtBasicServiceCodeWrapper implements ExtBasicServiceCodeWrapper {

    private transient ExtBearerServiceCodeWrapper extBearerServiceCodeWrapper = null;
    private transient ExtTeleserviceCodeWrapper extTeleserviceCodeWrapper = null;

    private final ExtBasicServiceCode extBasicServiceCode;

    public TxExtBasicServiceCodeWrapper(final ExtBasicServiceCode extBasicServiceCode) {
        this.extBasicServiceCode = extBasicServiceCode;
    }

    @Override
    public boolean isExtBearerServiceChosen() {
        return extBasicServiceCode.getExtBearerService() != null && extBasicServiceCode.getExtTeleservice() == null;
    }

    @Override
    public boolean isExtTeleserviceChosen() {
        return extBasicServiceCode.getExtBearerService() == null && extBasicServiceCode.getExtTeleservice() != null;
    }

    @Override
    public ExtBearerServiceCodeWrapper getExtBearerServiceCode() {
        if (this.extBearerServiceCodeWrapper == null && extBasicServiceCode.getExtBearerService() != null) {
            this.extBearerServiceCodeWrapper = new TxExtBearerServiceCodeWrapper(
                    extBasicServiceCode.getExtBearerService());
        }
        return this.extBearerServiceCodeWrapper;
    }

    @Override
    public ExtTeleserviceCodeWrapper getExtTeleserviceCode() {
        if (this.extTeleserviceCodeWrapper == null && extBasicServiceCode.getExtTeleservice() != null) {
            this.extTeleserviceCodeWrapper = new TxExtTeleserviceCodeWrapper(extBasicServiceCode.getExtTeleservice());
        }
        return this.extTeleserviceCodeWrapper;
    }

    public ExtBasicServiceCode getExtBasicServiceCode() {
        return this.extBasicServiceCode;
    }

    @Override
    public String toString() {
        return "TxExtBasicServiceCodeWrapper [extBasicServiceCode=" + extBasicServiceCode + "]";
    }

}
