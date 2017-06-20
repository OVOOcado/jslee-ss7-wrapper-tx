/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.InsertSubscriberDataResponse;
import pl.ovoo.ss7.wrapper.map.args.InsertSubscriberDataResponseWrapper;

/**
 * TxInsertSubscriberDataResponseWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxInsertSubscriberDataResponseWrapper implements InsertSubscriberDataResponseWrapper {

    private final InsertSubscriberDataResponse insertSubscriberDataResponse;

    public TxInsertSubscriberDataResponseWrapper(InsertSubscriberDataResponse insertSubscriberDataResponse) {
        super();
        this.insertSubscriberDataResponse = insertSubscriberDataResponse;
    }

    @Override
    public String toString() {
        return "TxInsertSubscriberDataResponseWrapper [insertSubscriberDataResponse=" + insertSubscriberDataResponse
                + "]";
    }

}
