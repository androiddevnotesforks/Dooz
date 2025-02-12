package io.github.yamin8000.dooz.content.game.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
internal fun DoozItem(
    shape: Shape,
    clickable: Boolean,
    size: Dp,
    hasOwner: Boolean,
    backgroundColor: Color,
    contentColor: Color,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(size)
            .clip(RoundedCornerShape(5.dp))
            .background(backgroundColor)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(),
                enabled = clickable,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center,
        content = {
            AnimatedVisibility(
                visible = hasOwner,
                enter = scaleIn(animationSpec = tween(150)),
                content = {
                    if (hasOwner) {
                        Box(
                            modifier = Modifier
                                .size((size.value / 2).dp)
                                .clip(shape)
                                .background(contentColor),
                        )
                    }
                }
            )
        }
    )
}