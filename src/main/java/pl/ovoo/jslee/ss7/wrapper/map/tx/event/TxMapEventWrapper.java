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

import org.mobicents.protocols.ss7.map.api.MAPDialog;
import org.mobicents.protocols.ss7.map.api.service.mobility.MAPDialogMobility;
import pl.ovoo.jslee.ss7.wrapper.map.MapDialogWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.event.MapEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.TxMapDialogWrapperImpl;

import javax.slee.ActivityContextInterface;


/**
 * TxEMapEventWrapper.
 *
 * @author kacper.mosienski@ovoo.pl
 */
public abstract class TxMapEventWrapper implements MapEventWrapper {

    /** The aci. */
    private final ActivityContextInterface aci;
    
    /** The dialog. */
    private final MAPDialog dialog;

    /**
     * Instantiates a new tx map event wrapper.
     *
     * @param aci the aci
     */
    public TxMapEventWrapper(final ActivityContextInterface aci) {
        this.aci = aci;
        this.dialog = (MAPDialog) aci.getActivity();
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.event.MapEventWrapper#getDialog()
     */
    @Override
    public MapDialogWrapper getDialog() {
        return createMapDialogWrapper();
    }

    /**
     * Creates the map dialog wrapper.
     *
     * @return the map dialog wrapper
     */
    private MapDialogWrapper createMapDialogWrapper() {
        if (dialog instanceof MAPDialogMobility) {
            final TxMapDialogWrapperImpl txMapDialogWrapperImpl = new TxMapDialogWrapperImpl((MAPDialogMobility)dialog);
            txMapDialogWrapperImpl.setActivityContextInterface(aci);
            return txMapDialogWrapperImpl;
        }
        return null;
    }

    /**
     * Gets the tx dialog.
     *
     * @return the tx dialog
     */
    protected MAPDialog getTxDialog() {
        return dialog;
    }

    /**
     * Gets the aci.
     *
     * @return the aci
     */
    protected ActivityContextInterface getAci() {
        return aci;
    }
}
