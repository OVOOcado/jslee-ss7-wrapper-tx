/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.event;

import org.mobicents.protocols.ss7.map.api.MAPMessage;
import org.mobicents.slee.resource.map.events.MAPEvent;
import pl.ovoo.ss7.wrapper.map.args.DialogOpenArgWrapper;
import pl.ovoo.ss7.wrapper.map.event.DialogOpenRequestEventWrapper;
import pl.ovoo.ss7.wrapper.map.event.MapEventWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxDialogOpenArgWrapper;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.slee.ActivityContextInterface;

/**
 * TxDialogOpenRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxDialogOpenRequestEventWrapper extends TxMapEventWrapper implements DialogOpenRequestEventWrapper {

    private final MAPEvent<MAPMessage> event;

    public TxDialogOpenRequestEventWrapper(final MAPEvent<MAPMessage> event, final ActivityContextInterface aci) {
        super(aci);
        this.event = event;
    }

    @Override
    public MapEventWrapper[] getComponentEvents() {
    	throw  new NotImplementedException();
    }

    @Override
    public DialogOpenArgWrapper getArgument() {
        return new TxDialogOpenArgWrapper(getTxDialog());
    }
    
    @Override
    public long getInvokeId(){
    	return event.getWrappedEvent().getInvokeId();
    }

}
