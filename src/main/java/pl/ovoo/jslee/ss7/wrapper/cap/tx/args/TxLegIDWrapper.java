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
 * OcLegIDWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxLegIDWrapper implements LegIDWrapper {

    /** The leg id. */
    private final LegID legID;

    /**
     * Instantiates a new tx leg id wrapper.
     *
     * @param legID the leg id
     */
    public TxLegIDWrapper(final LegID legID) {
        this.legID = legID;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.LegIDWrapper#getReceivingSideID()
     */
    @Override
    public LegType getReceivingSideID() {
        if (legID.getReceivingSideID() != null) {
            return LegType.valueOf(legID.getReceivingSideID().getCode());
        }
        return null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.LegIDWrapper#getSendingSideID()
     */
    @Override
    public LegType getSendingSideID() {
        if (legID.getSendingSideID() != null) {
            return LegType.valueOf(legID.getSendingSideID().getCode());
        }
        return null;
    }

    /**
     * Gets the tx leg id.
     *
     * @return the tx leg id
     */
    public LegID getTxLegID() {
        return legID;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (!(o instanceof TxLegIDWrapper))
            return false;

        final TxLegIDWrapper that = (TxLegIDWrapper) o;

        return legID != null ? (isSendingEqual(that) && isReceivingEqual(that)) : that.legID == null;
    }

    /**
     * Checks if is sending equal.
     *
     * @param that the that
     * @return true, if is sending equal
     */
    private boolean isSendingEqual(final TxLegIDWrapper that) {
        return legID.getSendingSideID() != null ? legID.getSendingSideID().equals(that.legID.getSendingSideID())
                : that.legID.getSendingSideID() == null;
    }

    /**
     * Checks if is receiving equal.
     *
     * @param that the that
     * @return true, if is receiving equal
     */
    private boolean isReceivingEqual(final TxLegIDWrapper that) {
        return legID.getReceivingSideID() != null ? legID.getReceivingSideID().equals(that.legID.getReceivingSideID())
                : that.legID.getReceivingSideID() == null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return legID != null ? legID.hashCode() : 0;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.LegIDWrapper#isReceivingSideIDChosen()
     */
    @Override
    public boolean isReceivingSideIDChosen() {
        return legID.getReceivingSideID() != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.LegIDWrapper#isSendingSideIDChosen()
     */
    @Override
    public boolean isSendingSideIDChosen() {
        return legID.getSendingSideID() != null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxLegIDWrapper [legID=" + legID + "]";
    }

}
