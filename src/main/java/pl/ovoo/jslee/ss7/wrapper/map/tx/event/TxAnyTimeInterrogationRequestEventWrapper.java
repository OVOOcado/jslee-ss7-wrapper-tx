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

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.AnyTimeInterrogationRequest;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxAnyTimeInterrogationArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.AnyTimeInterrogationArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.event.AnyTimeInterrogationRequestEventWrapper;

import javax.slee.ActivityContextInterface;


/**
 * TxAnyTimeInterrogationResultEventWrapper.
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxAnyTimeInterrogationRequestEventWrapper extends TxMapEventWrapper implements AnyTimeInterrogationRequestEventWrapper{

    /** The any time interrogation request. */
    private final AnyTimeInterrogationRequest anyTimeInterrogationRequest;

    /**
     * Instantiates a new tx any time interrogation request event wrapper.
     *
     * @param anyTimeInterrogationRequest the any time interrogation request
     * @param aci the aci
     */
    public TxAnyTimeInterrogationRequestEventWrapper(final AnyTimeInterrogationRequest anyTimeInterrogationRequest, final ActivityContextInterface aci) {
        super(aci);
        this.anyTimeInterrogationRequest = anyTimeInterrogationRequest;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.event.AnyTimeInterrogationRequestEventWrapper#getArgument()
     */
    @Override
    public AnyTimeInterrogationArgWrapper getArgument() {
    	AnyTimeInterrogationArgWrapper ati = new TxAnyTimeInterrogationArgWrapper(anyTimeInterrogationRequest);
    	return ati;
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.event.MapEventWrapper#getInvokeId()
     */
    @Override
    public long getInvokeId(){
    	return anyTimeInterrogationRequest.getInvokeId();
    }
}
