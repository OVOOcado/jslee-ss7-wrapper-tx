/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.common.telestax;

import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
import pl.ovoo.ss7.wrapper.common.args.IMSIAddressWrapper;

/**
 * TxIMSIAddressWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxIMSIAddressWrapper implements IMSIAddressWrapper{

    private final IMSI imsi;

    public TxIMSIAddressWrapper(final IMSI imsi) {
        this.imsi = imsi;
    }

    @Override
    public String getAddress() {
        return imsi.getData();
    }
    
    public IMSI getTxImsi(){
    	return imsi;
    }
}
