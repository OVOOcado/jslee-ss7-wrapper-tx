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

import org.mobicents.protocols.ss7.map.api.MAPMessage;
import org.mobicents.slee.resource.map.events.MAPEvent;
import pl.ovoo.jslee.ss7.wrapper.map.args.DialogOpenArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.event.DialogOpenRequestEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.event.MapEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxDialogOpenArgWrapper;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.slee.ActivityContextInterface;


/**
 * TxDialogOpenRequestEventWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxDialogOpenRequestEventWrapper extends TxMapEventWrapper implements DialogOpenRequestEventWrapper {

    /** The event. */
    private final MAPEvent<MAPMessage> event;

    /**
     * Instantiates a new tx dialog open request event wrapper.
     *
     * @param event the event
     * @param aci the aci
     */
    public TxDialogOpenRequestEventWrapper(final MAPEvent<MAPMessage> event, final ActivityContextInterface aci) {
        super(aci);
        this.event = event;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.event.DialogOpenRequestEventWrapper#getComponentEvents()
     */
    @Override
    public MapEventWrapper[] getComponentEvents() {
    	throw  new NotImplementedException();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.event.DialogOpenRequestEventWrapper#getArgument()
     */
    @Override
    public DialogOpenArgWrapper getArgument() {
        return new TxDialogOpenArgWrapper(getTxDialog());
    }
    
    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.event.MapEventWrapper#getInvokeId()
     */
    @Override
    public long getInvokeId(){
    	return event.getWrappedEvent().getInvokeId();
    }

}
