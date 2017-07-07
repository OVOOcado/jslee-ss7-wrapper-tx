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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args;

import org.mobicents.protocols.ss7.inap.api.primitives.LegID;
import pl.ovoo.jslee.ss7.wrapper.cap.args.LegIDWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.LegType;

/**
 * OcLegIDWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxLegIDWrapper implements LegIDWrapper {

    private final LegID legID;

    public TxLegIDWrapper(final LegID legID) {
        this.legID = legID;
    }

    @Override
    public LegType getReceivingSideID() {
        if (legID.getReceivingSideID() != null) {
            return LegType.valueOf(legID.getReceivingSideID().getCode());
        }
        return null;
    }

    @Override
    public LegType getSendingSideID() {
        if (legID.getSendingSideID() != null) {
            return LegType.valueOf(legID.getSendingSideID().getCode());
        }
        return null;
    }

    public LegID getTxLegID() {
        return legID;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (!(o instanceof TxLegIDWrapper))
            return false;

        final TxLegIDWrapper that = (TxLegIDWrapper) o;

        return legID != null ? (isSendingEqual(that) && isReceivingEqual(that)) : that.legID == null;
    }

    private boolean isSendingEqual(final TxLegIDWrapper that) {
        return legID.getSendingSideID() != null ? legID.getSendingSideID().equals(that.legID.getSendingSideID())
                : that.legID.getSendingSideID() == null;
    }

    private boolean isReceivingEqual(final TxLegIDWrapper that) {
        return legID.getReceivingSideID() != null ? legID.getReceivingSideID().equals(that.legID.getReceivingSideID())
                : that.legID.getReceivingSideID() == null;
    }

    @Override
    public int hashCode() {
        return legID != null ? legID.hashCode() : 0;
    }

    @Override
    public boolean isReceivingSideIDChosen() {
        return legID.getReceivingSideID() != null;
    }

    @Override
    public boolean isSendingSideIDChosen() {
        return legID.getSendingSideID() != null;
    }

    @Override
    public String toString() {
        return "TxLegIDWrapper [legID=" + legID + "]";
    }

}
