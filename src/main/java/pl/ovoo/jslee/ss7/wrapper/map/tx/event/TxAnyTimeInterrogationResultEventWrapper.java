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

import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.AnyTimeInterrogationResponse;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxAnyTimeInterrogationResultWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.AnyTimeInterrogationResultWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.MAPSubscriberInfoWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.event.AnyTimeInterrogationResultEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxMAPSubscriberInfoWrapper;

import javax.slee.ActivityContextInterface;


/**
 * TxAnyTimeInterrogationResultEventWrapper.
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxAnyTimeInterrogationResultEventWrapper extends TxMapEventWrapper implements AnyTimeInterrogationResultEventWrapper {

    /** The any time interrogation response. */
    private final AnyTimeInterrogationResponse anyTimeInterrogationResponse;

    /**
     * Instantiates a new tx any time interrogation result event wrapper.
     *
     * @param anyTimeInterrogationResponse the any time interrogation response
     * @param aci the aci
     */
    public TxAnyTimeInterrogationResultEventWrapper(final AnyTimeInterrogationResponse anyTimeInterrogationResponse, final ActivityContextInterface aci) {
        super(aci);
        this.anyTimeInterrogationResponse = anyTimeInterrogationResponse;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.event.AnyTimeInterrogationResultEventWrapper#getArgument()
     */
    @Override
    public AnyTimeInterrogationResultWrapper getArgument() {
    	MAPSubscriberInfoWrapper mAPSubscriberInfoWrapper = null;
    	if(anyTimeInterrogationResponse.getSubscriberInfo()!= null){
    		mAPSubscriberInfoWrapper = new TxMAPSubscriberInfoWrapper(anyTimeInterrogationResponse.getSubscriberInfo());
    	}
        return new TxAnyTimeInterrogationResultWrapper(mAPSubscriberInfoWrapper);
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.event.MapEventWrapper#getInvokeId()
     */
    @Override
    public long getInvokeId(){
    	return anyTimeInterrogationResponse.getInvokeId();
    }
}
