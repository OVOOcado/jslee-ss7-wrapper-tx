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

import org.mobicents.slee.resource.map.events.DialogRelease;
import pl.ovoo.ss7.wrapper.map.event.DialogReleaseEventWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxDialogCloseEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxDialogReleaseEventWrapper extends TxMapEventWrapper implements DialogReleaseEventWrapper {

    private final DialogRelease dialogRelease;

    public TxDialogReleaseEventWrapper(final DialogRelease dialogRelease, final ActivityContextInterface aci) {
        super(aci);
        this.dialogRelease = dialogRelease;
    }
    
    @Override
    public long getInvokeId(){
    	return dialogRelease.getWrappedEvent().getInvokeId();
    }
}
