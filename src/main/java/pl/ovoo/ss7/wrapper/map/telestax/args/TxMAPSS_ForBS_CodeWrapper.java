/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.service.supplementary.SSForBSCode;
import pl.ovoo.ss7.wrapper.map.args.MAPSS_ForBS_CodeWrapper;

/**
 * TxMAPSS_ForBS_CodeWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxMAPSS_ForBS_CodeWrapper implements MAPSS_ForBS_CodeWrapper {

    private final SSForBSCode sSForBSCode;

    public TxMAPSS_ForBS_CodeWrapper(final SSForBSCode sSForBSCode) {
        this.sSForBSCode = sSForBSCode;
    }

    public SSForBSCode getTxSSForBSCode() {
        return sSForBSCode;
    }

    @Override
    public String toString() {
        return "TxMAPSS_ForBS_CodeWrapper [sSForBSCode=" + sSForBSCode + "]";
    }

}
