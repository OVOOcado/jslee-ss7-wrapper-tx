/*
 * JSLEE SS7 Wrapper Tx
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the JSLEE SS7 Wrapper Tx.
 *
 * JSLEE SS7 Wrapper Tx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JSLEE SS7 Wrapper Tx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.ovoo.jslee.ss7.wrapper.map.tx.event;

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.InsertSubscriberDataRequest;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxInsertSubscriberDataArg_v1Wrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.InsertSubscriberDataArg_v1Wrapper;
import pl.ovoo.jslee.ss7.wrapper.map.event.InsertSubscriberDataRequestEventWrapper;

import javax.slee.ActivityContextInterface;


/**
 * TxInsertSubscriberDataRequestEventWrapper.
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxInsertSubscriberDataRequestEventWrapper extends TxMapEventWrapper implements InsertSubscriberDataRequestEventWrapper {

	/** The insert subscriber data request. */
	private final InsertSubscriberDataRequest insertSubscriberDataRequest;

    /**
     * Instantiates a new tx insert subscriber data request event wrapper.
     *
     * @param insertSubscriberDataRequest the insert subscriber data request
     * @param aci the aci
     */
    public TxInsertSubscriberDataRequestEventWrapper(final InsertSubscriberDataRequest insertSubscriberDataRequest, final ActivityContextInterface aci) {
        super(aci);
        this.insertSubscriberDataRequest = insertSubscriberDataRequest;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.event.InsertSubscriberDataRequestEventWrapper#getArgument()
     */
    @Override
    public InsertSubscriberDataArg_v1Wrapper getArgument() {
    	InsertSubscriberDataArg_v1Wrapper isd = new TxInsertSubscriberDataArg_v1Wrapper(insertSubscriberDataRequest);
    	return isd;
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.event.MapEventWrapper#getInvokeId()
     */
    @Override
    public long getInvokeId(){
    	return insertSubscriberDataRequest.getInvokeId();
    }
}
