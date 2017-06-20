/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtBasicServiceCode;
import pl.ovoo.ss7.wrapper.map.args.MAPExt_BasicServiceCodeWrapper;

/**
 * TxMAPExt_BasicServiceCodeWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxMAPExt_BasicServiceCodeWrapper implements MAPExt_BasicServiceCodeWrapper {

    private ExtBasicServiceCode basicServiceCode;

    public TxMAPExt_BasicServiceCodeWrapper(final ExtBasicServiceCode basicServiceCode) {
        this.basicServiceCode = basicServiceCode;
    }

    @Override
    public byte[] getExt_Teleservice() {
        if (basicServiceCode.getExtTeleservice() != null) {
            return basicServiceCode.getExtTeleservice().getData();
        }
        return null;
    }

    public ExtBasicServiceCode getTxMAPExt_BasicServiceCode() {
        return basicServiceCode;
    }

    @Override
    public String toString() {
        return "TxMAPExt_BasicServiceCodeWrapper [basicServiceCode=" + basicServiceCode + "]";
    }

}
