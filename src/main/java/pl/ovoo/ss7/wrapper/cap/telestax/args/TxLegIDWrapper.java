/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.inap.api.primitives.LegID;
import pl.ovoo.ss7.wrapper.cap.args.LegIDWrapper;
import pl.ovoo.ss7.wrapper.cap.args.LegType;

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
