/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.event;

import org.mobicents.protocols.ss7.map.api.MAPDialog;
import org.mobicents.protocols.ss7.map.api.service.mobility.MAPDialogMobility;
import pl.ovoo.ss7.wrapper.map.MapDialogWrapper;
import pl.ovoo.ss7.wrapper.map.event.MapEventWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.TxMapDialogWrapperImpl;

import javax.slee.ActivityContextInterface;

/**
 * TxEMapEventWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public abstract class TxMapEventWrapper implements MapEventWrapper {

    private final ActivityContextInterface aci;
    private final MAPDialog dialog;

    public TxMapEventWrapper(final ActivityContextInterface aci) {
        this.aci = aci;
        this.dialog = (MAPDialog) aci.getActivity();
    }

    @Override
    public MapDialogWrapper getDialog() {
        return createMapDialogWrapper();
    }

    private MapDialogWrapper createMapDialogWrapper() {
        if (dialog instanceof MAPDialogMobility) {
            final TxMapDialogWrapperImpl txMapDialogWrapperImpl = new TxMapDialogWrapperImpl((MAPDialogMobility)dialog);
            txMapDialogWrapperImpl.setActivityContextInterface(aci);
            return txMapDialogWrapperImpl;
        }
        return null;
    }

    protected MAPDialog getTxDialog() {
        return dialog;
    }

    protected ActivityContextInterface getAci() {
        return aci;
    }
}
