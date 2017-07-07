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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.event;

import org.mobicents.slee.resource.cap.events.DialogAccept;
import pl.ovoo.jslee.ss7.wrapper.cap.event.DialogOpenAcceptEventWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxDialogOpenAcceptEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxDialogOpenAcceptEventWrapper extends TxEventWrapper implements DialogOpenAcceptEventWrapper {

    private final DialogAccept dialogAccept;

    public TxDialogOpenAcceptEventWrapper(final DialogAccept dialogAccept, final ActivityContextInterface aci) {
        super(aci, dialogAccept.getWrappedEvent());
        this.dialogAccept = dialogAccept;
    }
}
